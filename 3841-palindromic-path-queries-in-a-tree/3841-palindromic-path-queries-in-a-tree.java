
import java.util.*;

class Solution {
    private int n;
    private List<Integer>[] adj;
    private int[] parent, depth, size, heavy, head, pos;
    private int[] seg;
    private int timer;

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        this.n = n;

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        size = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];

        Arrays.fill(parent, -1);
        Arrays.fill(heavy, -1);

        // Build parent, depth and traversal order.
        int[] order = new int[n];
        int count = 0;
        order[count++] = 0;
        parent[0] = 0;

        for (int i = 0; i < count; i++) {
            int u = order[i];

            for (int v : adj[u]) {
                if (parent[v] == -1) {
                    parent[v] = u;
                    depth[v] = depth[u] + 1;
                    order[count++] = v;
                }
            }
        }

        // Calculate subtree sizes and heavy children.
        Arrays.fill(size, 1);

        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            int p = parent[u];

            size[p] += size[u];

            if (heavy[p] == -1 ||
                    size[u] > size[heavy[p]]) {
                heavy[p] = u;
            }
        }

        // Heavy-Light Decomposition.
        int[] stackNode = new int[n];
        int[] stackHead = new int[n];
        int top = 0;

        stackNode[top] = 0;
        stackHead[top++] = 0;
        timer = 0;

        while (top > 0) {
            int start = stackNode[--top];
            int chainHead = stackHead[top];

            for (int u = start; u != -1; u = heavy[u]) {
                head[u] = chainHead;
                pos[u] = timer++;

                for (int v : adj[u]) {
                    if (parent[v] == u && v != heavy[u]) {
                        stackNode[top] = v;
                        stackHead[top++] = v;
                    }
                }
            }
        }

        // Build segment tree with character bitmasks.
        int[] base = new int[n];

        for (int u = 0; u < n; u++) {
            base[pos[u]] = charMask(s.charAt(u));
        }

        seg = new int[4 * n];
        build(1, 0, n - 1, base);

        List<Boolean> result = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split("\\s+");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                update(
                    1, 0, n - 1,
                    pos[u], charMask(c)
                );
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int mask = pathMask(u, v);

                result.add((mask & (mask - 1)) == 0);
            }
        }

        return result;
    }

    private int charMask(char c) {
        return 1 << (c - 'a');
    }

    private int pathMask(int u, int v) {
        int mask = 0;

        while (head[u] != head[v]) {
            if (depth[head[u]] < depth[head[v]]) {
                int temp = u;
                u = v;
                v = temp;
            }

            mask ^= rangeQuery(
                1, 0, n - 1, pos[head[u]], pos[u]
            );

            u = parent[head[u]];
        }

        if (depth[u] > depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        mask ^= rangeQuery(1, 0, n - 1, pos[u], pos[v]);

        return mask;
    }

    private void build(int node, int l, int r, int[] base) {
        if (l == r) {
            seg[node] = base[l];
            return;
        }

        int mid = (l + r) / 2;
        build(node * 2, l, mid, base);
        build(node * 2 + 1, mid + 1, r, base);

        seg[node] = seg[node * 2] ^ seg[node * 2 + 1];
    }

    private void update(
            int node, int l, int r, int idx, int value) {

        if (l == r) {
            seg[node] = value;
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid) {
            update(node * 2, l, mid, idx, value);
        } else {
            update(node * 2 + 1, mid + 1, r, idx, value);
        }

        seg[node] = seg[node * 2] ^ seg[node * 2 + 1];
    }

    private int rangeQuery(
            int node, int l, int r, int ql, int qr) {

        if (ql <= l && r <= qr) {
            return seg[node];
        }

        int mid = (l + r) / 2;
        int result = 0;

        if (ql <= mid) {
            result ^= rangeQuery(
                node * 2, l, mid, ql, qr
            );
        }

        if (qr > mid) {
            result ^= rangeQuery(
                node * 2 + 1, mid + 1, r, ql, qr
            );
        }

        return result;
    }
}

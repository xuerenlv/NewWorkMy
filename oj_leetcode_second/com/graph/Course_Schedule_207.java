package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Course_Schedule_207 {

	public static void main(String[] args) {
		int[][] prerequisites = new int[1][2];
		prerequisites[0][0] = 0;
		prerequisites[0][1] = 1;
		// prerequisites[1][0] = 1;
		// prerequisites[1][1] = 2;
		// prerequisites[2][0] = 1;
		// prerequisites[2][1] = 2;

		System.out.println(new Solution_Course_Schedule_207().canFinish_new(2, prerequisites));
	}

}

class Solution_Course_Schedule_207 {
	// ************************************************************************
	public boolean canFinish_new(int numCourses, int[][] prerequisites) {
		ArrayList<Integer>[] adj_list = new ArrayList[numCourses];

		int[] ru_du_arr = new int[numCourses];
		int count = 0;

		for (int i = 0; i < prerequisites.length; i++) {
			if (adj_list[prerequisites[i][0]] == null)
				adj_list[prerequisites[i][0]] = new ArrayList<>();
			ru_du_arr[prerequisites[i][1]]++;
			adj_list[prerequisites[i][0]].add(prerequisites[i][1]);
		}

		Queue<Integer> qu = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (ru_du_arr[i] == 0) {
				qu.offer(i);
				count++;
			}
		}

		while (!qu.isEmpty()) {
			int index = qu.poll();
			if (adj_list[index] == null)
				continue;
			for (int j = 0; j < adj_list[index].size(); j++) {
				if (--ru_du_arr[adj_list[index].get(j)] == 0) {
					qu.offer(adj_list[index].get(j));
					count++;
				}
			}
		}

		return count == numCourses;
	}

	// ************************************************************************
	public boolean canFinish_222(int numCourses, int[][] prerequisites) {
		ArrayList[] graph = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++)
			graph[i] = new ArrayList();

		boolean[] visited = new boolean[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			graph[prerequisites[i][1]].add(prerequisites[i][0]);
		}

		for (int i = 0; i < numCourses; i++) {
			if (!dfs(graph, visited, i))
				return false;
		}
		return true;
	}

	// 正常的时候是可以继续进行深度优先搜索，不正常的时候是不可以进行深度优先搜索
	private boolean dfs(ArrayList[] graph, boolean[] visited, int course) {
		if (visited[course])
			return false;

		visited[course] = true;
		for (int i = 0; i < graph[course].size(); i++) {
			if (!dfs(graph, visited, (int) graph[course].get(i)))
				return false;
		}
		visited[course] = false;
		return true;
	}

	// 2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222
	public boolean canFinish___2(int numCourses, int[][] prerequisites) {
		Graph graph = new Graph(numCourses);

		for (int i = 0; i < prerequisites.length; i++)
			graph.addEdge(prerequisites[i][0], prerequisites[i][1]);

		return !graph.isCyclic();
	}

	class Graph {
		int n; // number of vertex
		int[][] matrix; // adjacency matrix

		Graph(int x) {
			n = x;
			matrix = new int[n][n];
		}

		void addEdge(int u, int v) {
			matrix[u][v] = 1;
		}

		// check if there's a cycle in the graph
		boolean isCyclic() {
			boolean[] visited = new boolean[n];
			boolean[] stack = new boolean[n];

			for (int u = 0; u < n; u++)
				if (dfs(u, visited, stack))
					return true;

			return false;
		}

		boolean dfs(int u, boolean[] visited, boolean[] stack) {
			// mark it as visited
			visited[u] = true;
			stack[u] = true;

			// check all its neighbors
			for (int v = 0; v < n; v++)
				if (matrix[u][v] > 0)
					if (stack[v] == true || (visited[v] == false && dfs(v, visited, stack)))
						return true;

			// remove the vertex from recursion stack
			stack[u] = false;

			return false;
		}
	}
}
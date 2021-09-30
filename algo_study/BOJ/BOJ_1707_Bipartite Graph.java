import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Algo2_부울경_4반_이정현 {

	//그래프의 간선을 저장하기 위한 배열 arr
	static ArrayList<Integer>[] arr;
	
	//정점 수
	static int V;
	
	//간선 수
	static int E;
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		//버퍼로 입력 받는다.
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

		//문자열 공백 기준으로 자르기 위해.
		StringTokenizer st1;
		
		//테스트 수
		int test = Integer.parseInt(br1.readLine());
		
		//테스트 케이스마다 반복
		for(int t=1; t<=test; t++)
		{
			//입력으로 들어온 문자열 자른다.
			st1 = new StringTokenizer(br1.readLine());
			
			//V와 E 입력 받음.
			V = Integer.parseInt(st1.nextToken());
			E = Integer.parseInt(st1.nextToken());
			
			//arr 배열을 할당해준다.
			arr = new ArrayList[V+1];
			
			//할당해준 arr의 원소마다 arraylist를 할당해준다.
			for(int a=1; a<=V; a++)
			{
				arr[a] = new ArrayList<Integer>();
			}
			
			//간선 입력 받기
			for(int a=0; a<E; a++)
			{
				//문자열 잘라준다.
				st1 = new StringTokenizer(br1.readLine());
				
				//간선의 양 정점을 입력으로 받는다.
				int st_V = Integer.parseInt(st1.nextToken());
				int ed_V = Integer.parseInt(st1.nextToken());
				
				//아래의 BFS 방법으로 푸는 데에 자신으로 방문하는 간선은 
				//의미가 없고 오히려 방해가 되어 무시해주었다.
				//if(st_V == ed_V) continue;
				
				//각 정점이 연결되는 다른 정점 정보를 저장해준다.
				arr[st_V].add(ed_V);
				arr[ed_V].add(st_V);
			}
			
			//이분그래프는 그래프 정점의 집합을 둘로 분할하여야하므로
			//정점의 개수가 2 이상인 경우부터 고려해야한다고 생각되는데
			//문제의 조건에서는 어째서인지 V는 1부터라고 되어있는데
			//정점 갯수가 하나인 경우 어떻게 처리하라는 조건이 없어서
			//그냥 1번 정점에 인접하는 노드가 없으니까
			//YES를 출력하게 함.
			if(V==1)
			{
				System.out.println("YES");
			}
			else
			{
				//BFS 함수로 true인지 false인지 확인하고 결과를 출력한다.
				if(BFS()== true ) System.out.println("YES");
				else System.out.println("NO");
			}
		}
		
	}
	
	
	//BFS를 이용해서 각 정점에서 다른 정점으로 갈때마다 번호를 매긴다.
	//이때 번호는 1과 2만을 이용하여 매긴다.
	//지금 정점이 1이라면 다음 방문하는 정점은 2를 매긴다.
	//지금 정점이 2라면 다음 방문하는 정점은 1을 매긴다.
	//만약 다른 정점으로 갈때 이미 번호가 매겨져있고 그 번호가 자신과 같은 번호라면
	//이분 그래프가 될 수 없으므로 false를 리턴
	//모든 정점을 방문했는데 그러한 경우가 없었다면 이분 그래프가 가능하다. true를 리턴.
	static boolean BFS()
	{
		//BFS 탐색을 위한 큐 Q1
		Queue<Integer> Q1 = new LinkedList<>();
		
		//이미 방문했는지와 그 정점에서의 번호를 매기기 위한 vis 배열
		int[] vis = new int[V+1];
		
		
		for(int b=1; b<=V; b++)
		{
			if(vis[b] ==0)
			{
				//큐에 1을 넣는다.
				Q1.offer(b);
				
				//1번 정점에 1을 매긴다.
				vis[b] = 1;
				
				//큐가 빌때까지 반복한다.
				while(!Q1.isEmpty())
				{
					//큐의 가장 앞에 것을 pop
					int cur = Q1.poll();
					
					//이번 정점과 연결되어 있는 정점들 전부 확인
					for(int a=0; a<arr[cur].size(); a++)
					{
						//다음 방문 노드
						int next_node = arr[cur].get(a);
						
						//만약 지금 정점에 매긴 번호와 다음 방문 노드에 매긴 번호가 같다면 false 리턴
						if(vis[next_node] == vis[cur]) return false;
						//그런 경우가 아니고 이미 방문한 경우. 큐에 안넣어주기 위해 continue
						if(vis[next_node] >0) continue;
						
						//아직 방문하지 않은 정점의 경우.
						//큐에 넣어준다.
						Q1.offer(next_node);
						
						//지금 정점에 매겨진 번호가 1이면 번호 2를, 2면 번호 1을 다음 노드에 매긴다.
						if(vis[cur] == 1) vis[next_node] = 2;
						if(vis[cur] == 2) vis[next_node] = 1;
					}
				}
			
			}
		}
		
		
		//문제 없이 모든 정점을 방문했으니 true 리턴.
		return true;
	}

}

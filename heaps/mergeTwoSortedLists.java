List<Integer> merge2SortedLists(List<Integer> f, List<Integer> s) {
	PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
for (int i = 0; i < f.size(); i++) {
		pqueue.add(f.get(i));
}
for (int i = 0; i < s.size(); i++) {
		pqueue.add(s.get(i));
}
List<Integer> answer = new ArrayList<Integer>();
Iterator it = pq.iterator();
while (it.hasNext()) {
		answer.add(it.next());
	}
return answer;
}


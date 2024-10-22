import java.util.*;

//Basically a struct container type
class Job implements Comparable<Job>{
	public int start;
	public int finish;
	public String name;

	public Job(int start, int finish, String name){
		this.start=start;
		this.finish=finish;
		this.name=name;
	}

	//Compare jobs by finish time
	@Override
	public int compareTo(Job job) {
		return this.finish - job.finish;
	}
	
	@Override
	public String toString(){
		return "[" + name + ": (" + start + ", " + finish + ")]";
	}
}

public class IntervalScheduling {
	public static void findOptimalJobSchedule(Job[] jobs){
		System.out.println("Input Jobs: \t" + Arrays.toString(jobs));
		Arrays.sort(jobs);		//Sort jobs by finish time

		LinkedList<Job> jobsSelected = new LinkedList<Job>();
		jobsSelected.add(jobs[0]);		//add 1st job
		Job lastJobAdded = jobs[0];

		for(int i=1; i<jobs.length; i++){
			if(jobs[i].start >= lastJobAdded.finish){		//check if job is compatible (starts after or at the time time as the last job finishes)
				jobsSelected.add(jobs[i]);
				lastJobAdded = jobs[i];		//update for the job that was just added
			}
		}

		System.out.println("\nSelected " + jobsSelected.size() + " Jobs: ");
		for(Job job : jobsSelected){
			System.out.println(job);
		}
	}
	
	
	public static void main(String[] args) {
		Job[] jobs = {
			new Job(0, 6, "a"),
			new Job(1, 4, "b"),
			new Job(3, 5, "c"),
			new Job(3, 8, "d"),
			new Job(4, 7, "e"),
			new Job(5, 9, "f"),
			new Job(6, 10, "g"),
			new Job(8, 11, "h")
		};
		IntervalScheduling.findOptimalJobSchedule(jobs);
	}
}
n = int(input("Enter no. of processes: "))

pid = []
at = []
bt = []

for i in range(n):
    pid.append(i + 1)
    at.append(int(input(f"Enter arrival time for P{i+1}: ")))
    bt.append(int(input(f"Enter burst time for P{i+1}: ")))

# Sort processes by arrival time: (pid, at, bt)
processes = sorted(zip(pid, at, bt), key=lambda x: x[1])

ct = []   # Completion Time
tat = []  # Turnaround Time
wt = []   # Waiting Time
rt = []   # Response Time
pr = []   # Penalty/Performance Ratio = TAT / BT

time = 0

for p in processes:
    pid_i, at_i, bt_i = p

    # Start time is max(current time, arrival time)
    start_time = max(time, at_i)

    # Response time = first CPU start - arrival
    rt_i = start_time - at_i

    # Completion time = start time + burst
    time = start_time + bt_i
    ct_i = time

    tat_i = ct_i - at_i            # Turnaround time
    wt_i = tat_i - bt_i            # Waiting time
    pr_i = tat_i / bt_i            # Penalty/Performance ratio

    ct.append(ct_i)
    tat.append(tat_i)
    wt.append(wt_i)
    rt.append(rt_i)
    pr.append(pr_i)

print("\nPID\tAT\tBT\tCT\tTAT\tWT\tRT\tPR")

for i in range(n):
    print(f"{processes[i][0]}\t"
          f"{processes[i][1]}\t"
          f"{processes[i][2]}\t"
          f"{ct[i]}\t"
          f"{tat[i]}\t"
          f"{wt[i]}\t"
          f"{rt[i]}\t"
          f"{pr[i]:.2f}")

# Averages
avg_ct = sum(ct) / n
avg_tat = sum(tat) / n
avg_wt = sum(wt) / n
avg_rt = sum(rt) / n
avg_pr = sum(pr) / n

# Throughput = number of processes / total time (from first arrival to last completion)
first_arrival = processes[0][1]
last_completion = ct[-1]
total_time = last_completion - first_arrival
throughput = n / total_time if total_time > 0 else 0

print("\nAverage CT  =", avg_ct)
print("Average TAT =", avg_tat)
print("Average WT  =", avg_wt)
print("Average RT  =", avg_rt)
print("Average PR  =", avg_pr)
print("Throughput  =", throughput, "processes/unit time")
# simulation for synchronization OS Processes

this project is a simulation for synchronization multi processes to access and edit same address in memory

example:
![image](https://github.com/Abdelrahman-Elsayed-2001/simulation-for-synchronization-OS-Processes/assets/83625415/a80be70b-215d-4b01-8f7e-fe187fd33a2d)


processes:
![image](https://github.com/Abdelrahman-Elsayed-2001/simulation-for-synchronization-OS-Processes/assets/83625415/e432cb57-253e-42c2-bc7a-c3c9659f9a56)


So 
P1 and P3 want access Index 0
P2 and P4 want access Index 3
P5 want access Index 4

How to Synchronize it?
Sort process by Priority then FIFO (Frist in Frist Out)
Like this:
![image](https://github.com/Abdelrahman-Elsayed-2001/simulation-for-synchronization-OS-Processes/assets/83625415/6a6b0b46-814c-4adb-98b5-3cede61db30a)



Create threads to Synchronization:
Threads Created based on how many Index need to change 
at beginning I created thread for every Index need to change
means Thread for index 0 contains (P3 and P1)
and Thread for index 3 contains (P5)
and Thread for index 4 contains (P2 and P4)
but I desisted to create one Thread for every 2 indexes because the operation for every processes is simple and no need for create a lot of threads
so threads will be:
thread 1 for index 0 and index 3 {P3, P1, P5}
thread 2 for index 4 {P2 and P4}

![image](https://github.com/Abdelrahman-Elsayed-2001/simulation-for-synchronization-OS-Processes/assets/83625415/b290c73c-f7cf-490e-b1ec-a370dfdfc405)






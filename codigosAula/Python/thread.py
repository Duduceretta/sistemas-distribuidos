import threading

def tarefa():
    for i in range(50):
        print(i)

t = threading.Thread(target=tarefa)
t.start()

t1 = threading.Thread(target=tarefa)
t1.start()
file = open(r"C:\Users\jacks\Projects\Advent of Code\Advent_1.txt","r")
content = file.readlines()
total= 0
for i in range(len(content)):
    for c in content[i]:   
        result = ""
        if c.isdigit():
            result+=c
            break
    for c in reversed(content[i]):
        if c.isdigit():
            result+=c
            break
    total+=int(result)
print(total)
file.close()

#Total for Advent of Code 1 should be 53080
file = open(r"C:\Users\jacks\Projects\Advent of Code\Day 1\input.txt","r")
content = file.readlines() #Load lines into a list 
file.close()
total= 0
for i in range(len(content)): 
    for c in content[i]:   #Find first digit and appends it to result string.
        result = ""
        if c.isdigit():
            result+=c
            break
    for c in reversed(content[i]):
        if c.isdigit():    #Find first digit and appends it to result string.
            result+=c
            break
    total+=int(result) #Sum up the the result of each line in the file
print(total)

#Total for Advent of Code 1 should be 53080
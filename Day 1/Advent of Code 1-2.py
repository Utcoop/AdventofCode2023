file = open(r"C:\Users\jacks\Projects\Advent of Code\Advent_1.txt","r")
answer = open(r"C:\Users\jacks\Projects\Advent of Code\example","w")
content = file.readlines()
total= 0
dict = {"one":"1", "two":"2", "three":"3", "four":"4", "five":"5", "six":"6", "seven":"7", "eight":"8", "nine":"9"}

for i in range(len(content)):
    result=""
    indexKey= []
    position = {}

    for key in dict:
        start = 0
        bool = True
        while bool:
            if content[i].find(key, start)!=-1:
                index = content[i].find(key, start)
                position.update({index:key})
                indexKey.append(index)
                start += len(key)
                #print(key + " " + str(start) + " "+ str(bool))
            else:
                bool = False
    for c in range(len(content[i])):
        if content[i][c].isdigit():
            position.update({c:content[i][c]})
            indexKey.append(c)
    result += position.get(min(indexKey))
    result += position.get(max(indexKey))
    for key in dict:
        if key in result:
            result = result.replace(key, dict.get(key))
    total += int(result)
    answer.write("result: " + result + " total: "+ str(total)+"\n")
    #print(result)
    #print(position)
print(total)

file.close()
#81 need 88
file = open(r"C:\Users\jacks\Projects\Advent of Code\Day 1\input.txt","r")
content = file.readlines()
file.close()
total= 0
dict = {"one":"1", "two":"2", "three":"3", "four":"4", "five":"5", "six":"6", "seven":"7", "eight":"8", "nine":"9"} #Dictionairy used to convert numbers written out as strings  to integers.

for i in range(len(content)):
    result=""
    indexKey= [] #Stores the indexes of found words exclusively to be used as keys for the position dict.
    position = {} #Position Dict to store the first index of a Integer written out as a word
    for key in dict: #Loops over keys to seach for in the string
        start = 0
        bool = True
        while bool:
            if content[i].find(key, start)!=-1: #Searches from start to the end of the string to see if a key is contained in the string 
                index = content[i].find(key, start) #sets the returned index equal to variable index
                position.update({index:key}) 
                #print(position)
                indexKey.append(index) 
                start += len(key) #Updates the starting index of our search to the length of the current key
                #print(key + " " + str(start) + " "+ str(bool))
            else:
                bool = False
    for c in range(len(content[i])): #Iterates through the characters in the string
        if content[i][c].isdigit():  
            #print(position)
            position.update({c:content[i][c]}) #if the character is a digit update add the digit and the index of it two the position dict
            #print(position)
            indexKey.append(c) #Also add the index to indexkey
    result += position.get(min(indexKey)) #Find the smallest index in indexKey and use it as a key to find the corresponding value and append it to the result string
    result += position.get(max(indexKey)) #Find the largest index in indexKey and use it as a key to find the corresponding value and append it to the result string
    for key in dict:
        if key in result:
            print(result)
            result = result.replace(key, dict.get(key)) #Replaces any integers that are written out as strings with their corresponding integer
            print(result)
    total += int(result)
    #print(result)
    #print(position)
print(total)

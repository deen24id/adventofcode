local LINE_SEPARATOR = "\r\n" -- Using windows

local fs = require("@lune/fs")

local input = fs.readFile("./input/01-input.txt")

local array1 = {}
local array2 = {}

for _ , val in input:split(LINE_SEPARATOR) do
	local pair = val:split("   ")
	table.insert(array1,tonumber(pair[1]))
	table.insert(array2,tonumber(pair[2]))
end

table.sort(array1)
table.sort(array2)

local counter = 0
for index = 1, #array1 do
	counter = counter + math.abs(array1[index]::number - array2[index]::number)	
end

print(counter)
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

local dict = {}
for _ , val in array2 do
	local key = tostring(val)
	if dict[key] == nil then
		dict[key] = 1 
	else
		dict[key] = dict[key] + 1
	end
end


local counter = 0
for  _ , val in array1 do
	if dict[tostring(val)] ~= nil then counter = counter + val::number * dict[tostring(val)] end
end

print(counter)
local LINE_SEPARATOR = "\r\n" -- Using windows

local fs = require("@lune/fs")

local input = fs.readFile("./input/02-input.txt")

local counter = 0

for _ , val in input:split(LINE_SEPARATOR) do
	
	local temp: {string} = val:split(" ")
	local tempN: {number} = {}
	
	for key, val in pairs(temp) do
		tempN[key] = tonumber(val)::number --gauranteed to be number
	end

	local isIncreasingEnd = (tempN[1]- tempN[#tempN]) < 0

	for index = 1, #tempN do
		
		if index == #tempN then --only count when the iteration reach the array's end
			counter = counter + 1
			break
		end

		local diff = tempN[index] - tempN[index+1]
		local isIncreasingLocal = diff < 0
		if isIncreasingLocal ~= isIncreasingEnd or math.abs(diff) > 3 or diff == 0 then
			break --anything reach here will not be counted and break the loop
		end

	end

end

print(counter)
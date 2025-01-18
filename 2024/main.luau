local net = require("@lune/net")
local response = net.request("https://google.com")
if response.ok then
	print(
		"Google responded with status code",
		response.statusCode,
		"and response message",
		response.statusMessage,
		"!"
	)
else
	print("Google is down!! What?!?")
end
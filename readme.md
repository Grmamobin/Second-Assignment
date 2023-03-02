# Weather App Assignment

## Introduction
I built a simple Java application that connects to a weather API and retrieves information about the current weather conditions of a given city.
##  Summary
I used Swing for It's GUI and It outPuts the result in the JFrame . It contains Error message frame and Action event .
I complete the main function by input the city and I offer  2 options:
1) If the city does not exist or the net is too poor to check the weather of the city that you are looking for, it will outputs Error
2) In next part I called JASON object to figure out the humid then I put the key:Current in it. And with the advantage of JASON's get string I found the next key: humid.
And I did the same for other weather conditions.
At the time of printing I put the result in it's own specific function.
And the job of these function are to return string to Integer or double. (For prevent of over writing I toke wind speed in the temper function.)

## Features
   **Examples :**

known City --->[![Screenshot-2023-03-01-at-10-32-45.png](https://i.postimg.cc/Rhyhrj0n/Screenshot-2023-03-01-at-10-32-45.png)](https://postimg.cc/XBK4d1dV)[![Screenshot-2023-03-01-at-20-46-30.png](https://i.postimg.cc/GmwJ1BHT/Screenshot-2023-03-01-at-20-46-30.png)](https://postimg.cc/LnDZt8km)

Unknown City --->
[![Screenshot-2023-03-01-at-10-50-32.png](https://i.postimg.cc/90gVRSwF/Screenshot-2023-03-01-at-10-50-32.png)](https://postimg.cc/gLh11gKf)
[![Screenshot-2023-03-01-at-10-34-40.png](https://i.postimg.cc/gcXGQtvm/Screenshot-2023-03-01-at-10-34-40.png)](https://postimg.cc/Bt3W1gYV)

## Conclusion
If you want to revise it or make it better you can make shape for This GUI , and you can contain other condition that I didn't consider.(Cause I consider 4 weather conditions)

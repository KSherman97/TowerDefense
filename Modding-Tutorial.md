# HOW TO MAKE A MOD
If you want to customize the images, they can be found in the res directory. You just open them up in your favorite image editor and edit away. Any good editor / modder knows to back up the old images also. If you are interested in editing / adding maps to the game they can be found in the save directory. They must always have the .kyle extension to be able to be loaded. Here is an example mapn

## Sample Save file
20

0  0  0  0  0  0  0  0  0  0  0  0
1  1  1  0  1  1  1  1  1  1  1  0
0  0  1  0  1  0  0  0  0  0  1  0
0  0  1  0  1  1  1  1  0  0  1  0
0  0  1  0  0  0  0  1  0  0  1  0
0  0  1  0  0  0  0  1  0  0  1  0
0  0  1  1  1  1  1  1  0  0  1  1
0  0  0  0  0  0  0  0  0  0  0  0

-1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1
-1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1
-1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1
-1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1
-1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1
-1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1
-1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  0
-1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1

### Save file breakdown
Okay so let’s break this down a little so that you can get a better understanding of the structure and functionality of the map files:

-	The 20 on line one represents the number of mobs that must be killed in order to win the level
-	In the first square of 0s and 1s, a 0 represents grass, and the 1 represents the path that the mobs must take
-	In the second square that has the has the 0s and the -1s, a -1 is air(ignored by everything) and a 0 is the tower(this is to be placed at the end of the road that the mobs will travel on)
-	The mobs are coded to go from left to right so you need to design the map accordingly


If you feel that you have made a mod worth sharing email me the files and I would love to check them out. 

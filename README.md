Basic algebra calculator for recruitment processs

Time spent ~~ 1 hour

Alghoritm explenation:
- read file to array line by line
- split elements in array into two parts: operation and value
- add array elements into List<Pair>, where Pair is <String, Double> pair
- find 'APPLY' operation value, and set it as initial value, then remove this element from list
- calculate chain of defined operations 

Assumptions:
- 'APPLY' always occured and int gives initial value

Problems known / possible problems:
- handle weird input (like dividing by zero)
- Floating point operations can 'lose' the value due to their lack of precision

# Phonebook w/ Contacts
Tsee Lee, 7/21/20
## Considerations
Since insertion and search must be optimized, a hash table is the most
appropriate data structure by far. Hash tables offers constant runtime
on average, and with careful design we can avoid worst-case scenarios.
Other operations will be slower, while memory usage may be higher than
alternatives.

## Hash Table design
### Hash function & collision resolution
Since searches will be done by the last name, a function that converts
strings to indices is needed. A Google search will locate good functions,
like djb2, but a simpler one based on char * ordering can also work. Since
we're assuming last names are unique, collision would not be a problem. We
still have to plan for it, and a linked list is probably the simplest.
Most of the times there will be only one item in the list,
preserving constant time.
### Operations
1. add - O(1)
Apply the hash function to the last name to obtain index. Create a `person`
and store it in the array at that index. Since it's a linked list just add
to front.
- Occasionally, the array will get filled up. When the load factor approaches
70%, create a second table and start filling in there. As well, move a small
number of `person`s, maybe 3-5, at each add to the new array. When all
`person`s have been moved, delete the old array. O(2*1) is still O(1).
2. find - O(1)
Apply the hash function to the last name to obtain index. Check each `person`
in the linked list until contact is found, or not. If found, retrieve the
object and answer the queries, e.g. for phone number, first name, etc.
3. remove - O(1) on average, O(S) in worst case, where S is the size of the array
Apply the hash function to the last name to obtain index. Check each `person`
in the linked list until contact is found, and remove from the list if found
(connect parent node to the next node). Return the `person` if desired.
- Occasionally, so many records will have been deleted that the array is
mostly empty. When the load factor is too low, e.g. 25%, halve the array.
The load factor will still be low, ~50%, so a lot of insertions can be made
before the array will need to be enlarged.
- Making use of the smaller array will require recalculating all the indices.
This can take O(S) time, assuming minimal collisions. Since remove does not
have to optimized, the user will just have to wait.
4. printList - O(S), where S is the size of the array
This operation will be very slow. We have to traverse the whole array and
examine each element, which could be a linked list of contacts. Hopefully,
collisions are rare so we have constant time for linked list traversal.

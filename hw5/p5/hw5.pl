/*******************************************/
/**    Your solution goes in this file    **/ 
/*******************************************/

year_1953_1996_novels(A) :-
    novel(A, Year),
    (Year = 1953; Year = 1996).
    
period_1800_1900_novels(A) :-
    novel(A, Year),
    (Year > 1800,Year < 1900).

lotr_fans(A) :-
    fan(A, Name), 
    member(the_lord_of_the_rings, Name).

author_names(A):-
    author(A, _),
    author_names_help(A).

author_names_help(A) :-
    author(A, AList),
    fan(chandler, BList),
    member(X, AList),
    member(X, BList),
    !.
    
fans_names(A) :-
    fan(A, AList),
    author(brandon_sanderson, BList),
    member(X,AList),
    member(X,BList).

    
mutual_novels(A) :-
    novel(A,_),
    fan(phoebe, Plist),
    fan(ross, Rlist),
    fan(monica, Mlist),
    isIntersection(Plist, Rlist, Xlist),
    isIntersection(Rlist, Mlist, Ylist),
    isIntersection(Plist, Mlist, Zlist),
    (member(A, Xlist); member(A, Ylist); member(A, Zlist)). 

    
isMember(X,[H|T]):-
    X = H; isMember(X, T).

isUnion([],X,X).
isUnion([H|A], B, C) :- 
    member(H,B), !, isUnion(A,B,C).
isUnion([H|A],B,[H|C]):-
    isUnion(A,B,C).



isIntersection([],_,[]).
isIntersection([A|B],C,[A|E]):-
    isMember(A,C),
    isIntersection(B,C,E).
isIntersection([A|B],C,D):-
    \+ (isMember(A,C)),
    isIntersection(B,C,D).

        
isEqual(A,A) :- !.
isEqual([H|T],Y):-
    isMember(H,Y),
    select(H,Y,Z),
    isEqual(T,Z), 
    !.

subPower(A, [B], [[A| B]]).
subPower(A, S, P) :-
        S = [H| C],
        append([A], H, D),
        subPower(A, C, Rest),
        append([D], Rest, P), !.
powerSet([], [[]]).
powerSet(Set, P) :-
        Set = [H| T],
        powerSet(T, B),
        subPower(H, B, C),
        append(C, B, P), !.

left :-
	not(right).

right :-
	not(left).

state(left,left,right,left).


opposite(A,B) :-
	(A = left, B = right);
	(A = right, B = left).


unsafe(A) :-
	(A = state(B,C,C,_), opposite(C,B));
	(A = state(B,_,C,C), opposite(C,B)). 

safe(A):- \+ unsafe(A).

take(_,A,B) :- opposite(A,B).

arc(take(wolf, A, B), state(A,A,G,C), state(B,B,G,C)) :-
	opposite(A,B),
	safe(state(A,A,G,C)),
	safe(state(B,B,G,C)).
 
arc(take(goat, A, B), state(A,W,A,C), state(B,W,B,C)) :-
	opposite(A,B),
	safe(state(A,W,A,C)),
	safe(state(B,W,B,C)).

arc(take(cabbage, A, B), state(A,W,G,A), state(B,W,G,B)) :-
        opposite(A,B),
	safe(state(A,W,G,A)),
	safe(state(B,W,G,B)).

arc(take(none, A, B), state(A,W,G,C), state(B,W,G,C)) :-
        opposite(A,B),
	safe(state(A,W,G,C)),
	safe(state(B,W,G,C)).

solve :- go(state(left, left, left, left), state(right, right, right, right)).

go(Start, Stop) :-
	pathcontainer(Start, Stop, []),
	!.

pathcontainer(A, Z, Cont) :-
	Edge = arc(take(_,_,_), A, B),
	\+ member(Edge, Cont),
	Edge,
	pathcontainer(B, Z, [Edge|Cont]). 


pathcontainer(A, A, Cont) :-
	printpath(Cont),
	!.

printpath([]).
printpath([arc(T,_,_)|R]) :-
	printpath(R),
	print(T),nl.	

# Problem D. GoroSort
# http://code.google.com/codejam/contest/dashboard?c=975485#s=p3
#
# @author Felipe Ribeiro <felipernb@gmail.com>

t = input()
for i in xrange(t):
	n = input()
	numbers = []
	for n in raw_input().split():
		numbers.append(int(n))
	orderedNumbers = numbers[:]
	orderedNumbers.sort()
	changes = 0
	for j in xrange(len(numbers)):
		if orderedNumbers[j] != numbers[j]:
			changes +=1
	print "Case #%d: %0.06f" % (i+1,changes)


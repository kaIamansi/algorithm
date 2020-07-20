#include <string>
#include <vector>

using namespace std;

char ChangeTo124(int n) {
	switch (n) {
	case 0: return '4';
	case 1:	return '1';
	case 2: return '2';
	}
}

string solution(int n) {
	string answer = "";

	while (n > 0) {
		answer.insert(answer.begin(), ChangeTo124(n % 3));
		n--;
		n /= 3;
	}
	return answer;
}

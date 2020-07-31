문제를 보고 가장 먼저 생각났던 것은 비트마스크와 동적 계획법을 이용한 풀이였다. 구간별 캐시를 두고 무엇이 들어있는지 나타낸 비트마스크를 집어넣어 모든 비트가 true인 구간을 찾는 방식으로 생각했었다. 그러나 입력의 크기가 비트마스크를 이용할 수 없을 정도의 크기였기 때문에 다른 방식을 생각하기로 했다.


입력의 수가 크기 때문에 `O(n^2)`의 알고리즘은 효율적이지 못할 것 같았다. 최대한 빨리 해결하기 위해서 `unordered_set`으로 보석의 종류를 파악하고 `map` 즉, 해시 테이블을 이용해서 해당 보석이 있었던 마지막 위치가 어디인지 저장해놓고 해시 테이블이 집합과 원소의 수가 같아지면 처음 위치와 마지막 위치를 찾아 반환하는 방식의 알고리즘을 작성했다.

---
* 1차 코드
~~~cpp
#include <string>
#include <vector>
#include <unordered_set>
#include <map>
using namespace std;

inline int min(int a, int b) {
    return a < b ? a : b;
}

inline int max(int a, int b) {
    return a > b ? a : b;
}

vector<int> solution(vector<string> gems) {
    vector<int> answer = vector<int>((size_t)2);

    auto set = unordered_set<string>(gems.begin(), gems.end());
    map<string, int> dictionary = map<string, int>();

    vector<string>::iterator it = gems.begin();
    for (int i = 0; i < gems.size() && dictionary.size() < set.size(); i++) {
        if (dictionary.find(*it) == dictionary.end())
            dictionary.insert(make_pair(*it++, i + 1));
        else
            dictionary[*it++] = i + 1;
    }

    answer[0] = 10000000;
    answer[1] = -1;
    for (auto& d : dictionary) {
        answer[0] = min(answer[0], d.second);
        answer[1] = max(answer[1], d.second);
    }

    return answer;
}
~~~
---
이 과정에서 생각하지 못했던 문제가 있었다. 예시를 들자면 이렇다.
~~~
입력값: ["0", "1", "2", "2", "3", "0", "1", "2", "3"]
출력값: [4, 7]
~~~

위에서 작성했던 알고리즘은 보석이 모두 들어가있는 구간을 찾는 즉시 `for`문을 탈출한다. 그래서 그 뒤에 있을 수 있는 더 짧은 구간을 확인하지 못했던 것이다. 이를 고치기 위해서 `map`뿐만 아니라 위치만 저장하는 정렬된 컨테이너가 필요했다. 그래서 빠른 `list`를 이용해서 위의 문제는 해결했다.

시간적으로도 불안했던 면이 있어서 느린 `iterator`를 이용하는 것을 포기했다.

---
* 2차 코드
~~~cpp
#include <string>
#include <vector>
#include <unordered_set>
#include <list>
#include <unordered_map>
using namespace std;

vector<int> solution(vector<string> gems) {
    vector<int> answer = vector<int>{ 1, 10000000 };

    auto set = unordered_set<string>(gems.begin(), gems.end());
    unordered_map<string, int> dictionary = unordered_map<string, int>();

    list<int> li;
    for (int i = 0; i < gems.size(); i++) {
        if (dictionary.find(gems[i]) == dictionary.end())
            dictionary.insert(make_pair(gems[i], i + 1));
        else {
            li.remove(dictionary[gems[i]]);
            dictionary[gems[i]] = i + 1;
        }
        li.emplace_back(i + 1);

        if (dictionary.size() == set.size() && answer[1] - answer[0] > li.back() - li.front()) {
            answer[0] = li.front();
            answer[1] = li.back();
        }
    }

    return answer;
}
~~~
---
여기서 또 다른 문제가 생겼다. 효율성 테스트에서 시간 초과가 발생한 것이다. 이를 고치기 위해서 고민하는 중이다.

알고리즘에 대해서 간단히 정리하자면 이렇다.

1. `set`을 이용해서 보석의 종류를 가져온다.
2. `dictionary`에는 각 보석의 마지막 위치를 저장한다.
3. `li`는 보석의 위치만 저장하는 리스트이다. 처음부터 순차적으로 돌 것이기 때문에 항상 정렬되어 있다.
4. 처음부터 순회하면서 보석들의 마지막 위치를 찾는다.
5. 모든 보석의 위치가 `dictionary`에 등록이 되었다면 `li`의 양 끝과 기존 답을 비교해서 반환한다.

여기서 가장 시간을 많이 잡아먹는 부분은 `li.remove(dictionary[gems[i]])`라고 생각했다. 값을 찾기 위해서 `front`부터 선형탐색을 할 것이기 때문에, 최악의 상황에는 시간 복잡도 `O(n^2)`까지도 나올 수 있었다.

따라서, 값을 한 번에 찾을 수 있는 `map`을 사용하기로 했다. 더구나 `map`은 key 값을 기준으로 정렬이 된다는 점을 이용해서 `li.front()`의 기능도 할 수 있었다.

---
* 최종 코드

~~~cpp
#include <string>
#include <vector>
#include <unordered_set>
#include <unordered_map>
#include <map>
using namespace std;

vector<int> solution(vector<string> gems) {
    vector<int> answer = vector<int>{ 1, 10000000 };

    auto set = unordered_set<string>(gems.begin(), gems.end());
    unordered_map<string, int> dictionary;

    map<int, string> lastLocation;
    int min = 10000000;
    bool dictionaryFull = false;
    for (int i = 0; i < gems.size(); i++) {
        if (dictionary.find(gems[i]) == dictionary.end()) {
            dictionary.insert(make_pair(gems[i],i+1));
            lastLocation.insert(make_pair(i + 1, gems[i]));
            if (min == 10000000) min = i + 1;
        }
        else {
            if (gems[i] == lastLocation[min])
                min = (++lastLocation.begin())->first;

            lastLocation.erase(dictionary[gems[i]]);
            lastLocation.insert(make_pair(i + 1, gems[i]));
            dictionary[gems[i]] = i + 1;
        }

        if (dictionary.size() == set.size() && answer[1] - answer[0] > i + 1 - min) {
            answer[0] = min;
            answer[1] = i+1;
        }
    }

    return answer;
}
~~~
//#include <string>
//#include <vector>
//#include <unordered_map>
//#include <iostream>

//struct Album
//{
//    Album() {}
//
//    Album(string Gen, int Val) {
//        _Gen = Gen;
//        _Val = Val;
//    }
//
//    string _Gen;
//    int _Val;
//};
//
//vector<int> solution(vector<string> genres, vector<int> plays) {
//    vector<int> answer;
//    unordered_map<string, int> hashmap;
//
//    for (int i = 0; i < genres.size(); i++)
//    {
//        Album * al = new Album(genres[i], plays[i]);
//        hashmap.insert();
//    }
//
//    //for (int i = 0; i < genres.size(); i++)
//    //{
//    //    hashmap.insert(make_pair(genres[i], plays[i]));
//    //}
//
//    for (auto iter = hashmap.begin(); iter != hashmap.end(); iter++)
//    {
//        cout << iter->first << " " << iter->second << endl;
//    }
//    
//
//    return answer;
//}

#include <string>
#include <iostream>
#include <algorithm>
#include <vector>
#include <map>

using namespace std;

bool sortByVal(const pair<string, int>& a,
    const pair<string, int>& b)
{
    return (a.second > b.second);
}

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    multimap<int, pair<string, int>> m;
    map<string, int> sumMap;
    // multimap<int, pair<string, int>>::iterator iter;
    multimap <string, int> ::iterator iter2;
    vector<pair<string, int>> vec;
    
    string arr[] = {""};
    int count, sum = 0;
    
    for (int i = 0; i < genres.size(); i++)
    {
        m.insert(make_pair(i, make_pair(genres[i], plays[i])));
        // <인덱스, <장르, 플레이 횟수>>
        sumMap[genres[i]] += plays[i];
        // 장르별 플레이 횟수 저장
    }

    for (iter2 = sumMap.begin(); iter2 != sumMap.end(); iter2++)
    {
        vec.push_back(make_pair(iter2->first, iter2->second));
    }

    sort(vec.begin(), vec.end(), sortByVal);
    // sort by value

    for (int i = 0; i < vec.size(); i++)
    {
        cout << vec[i].first << " " << vec[i].second << endl;
    }

    return answer; // 엄준식
}

int main()
{
    vector<string> gen;
    vector<int> ply;
    vector<int> answer;

    gen.push_back("classic");
    gen.push_back("pop");
    gen.push_back("classic");
    gen.push_back("classic");
    gen.push_back("pop");

    ply.push_back(500);
    ply.push_back(600);
    ply.push_back(150);
    ply.push_back(800);
    ply.push_back(2500);

    answer = solution(gen, ply);
}
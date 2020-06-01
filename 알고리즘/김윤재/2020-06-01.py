from collections import defaultdict


def solution(genres, plays):
    # a = {"classic", [1450, [(500, 0), (150, 2), (800, 3)]]}
    answer = []
    map = defaultdict(lambda: [0, []])

    for idx, genre in enumerate(genres):
        play_times = plays[idx]
        map[genre][0] += play_times
        map[genre][1].append((play_times, idx))

    for genre in sorted(map.items(), key=lambda x: x[1][0], reverse=True):
        for idx_2, play_list in enumerate(sorted(genre[1][1], key=lambda x: x[0], reverse=True)):
            if idx_2 >= 2:
                break
            answer.append(play_list[1])

    return answer


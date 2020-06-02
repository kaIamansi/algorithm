def semi_solution(genres, plays, sorted_dict):
    answer = []

    for key in sorted_dict.keys():
        if len(sorted_dict[key]) == 2:
            answer.append(plays.index(sorted_dict[key][0]))
            plays[plays.index(sorted_dict[key][0])] = 500000
        else:
            for i in range(len(sorted_dict[key]) - 2, len(sorted_dict[key]) - 4, -1):
                for j in range(len(genres)):
                    if sorted_dict[key][i] == plays[j] and key == genres[j]:
                        # answer.append(plays.index(sorted_dict[key][i]))
                        answer.append(j)
                        plays[j] = 5000000
                        break
    return answer


def sort_dict(album_dict):
    for key in album_dict.keys():
        album_dict[key].append(sum(album_dict[key]))
        album_dict[key] = sorted(album_dict[key])

    album_dict = dict(sorted(album_dict.items(), key=lambda e: e[-1], reverse=True))

    return album_dict


def create_dict(genres, plays):
    album_dict = {}

    for key, value in zip(genres, plays):
        if key in album_dict:
            album_dict[key].append(value)

        else:
            album_dict[key] = [value]

    return album_dict


def solution(genres, plays):
    album_dict = create_dict(genres, plays)
    sorted_dict = sort_dict(album_dict)
    answer = semi_solution(genres, plays, sorted_dict)

    return answer
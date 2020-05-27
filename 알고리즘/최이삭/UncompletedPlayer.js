function solution(participant, completion) {
    let answer = ""
    let participantObject = {}
    participant.forEach(part => {
        if(participantObject.hasOwnProperty(part))
            participantObject[part] += 1;
        else
            participantObject[part] = 1;
    })
    completion.forEach(part => {
        participantObject[part] -= 1;
        if(participantObject[part] === 0) {
            delete participantObject[part]
        }
    })
    for(let part in participantObject) {
        answer = part;
    }
    return answer
}
function solution(board, moves) {
    const basket = [];
    let result = 0;

    moves.forEach(move => {
        let v = move - 1;
        let doll = null;

        for (let i = 0; i < board.length; i++) {
            if (board[i][v] !== 0) {
                doll = board[i][v];
                board[i][v] = 0;
                break;
            }
        }

        if (doll !== null) {
            if (basket[basket.length - 1] === doll) {
                basket.pop();
                result += 2;
            }

            else basket.push(doll);
        }
    });
    return result;
}
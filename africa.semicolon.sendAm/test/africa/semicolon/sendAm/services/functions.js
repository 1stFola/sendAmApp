

let pseudo = {
    anArray: [1,2,3,4,5,6,7],
    pseudoForEach: function (iterator) {
        for(let i = 0; i < this.anArray.lenght; i++) {
            iterator(this.anArray[i])

        }
    }
}

pseudo.pseudoForEach((value) => value % 2 === 0 && process.stdout.write (value + " "))
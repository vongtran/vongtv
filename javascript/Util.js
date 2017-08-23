function printWords(count) {
    for (var i = 0; i < (count/2 - 1); i++) {
        printCoupleWords();
    }
    printLastWords(count);
}

function printCoupleWords() {
    console.log("foo\n\rbar");
} 

function printLastWords(count) {
    if ((count % 2) === 1) {
        console.log("yahoo");
    } else {
        console.log("foo\n\ryahoo");
    }
    
}



/**
 * @return {Function}
 */
var createHelloWorld = function() {
    
    function temp() {
        return "Hello World";
    }

    return temp;
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */
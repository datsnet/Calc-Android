#include "Calculator.h"
#include "DivideByZeroException.h"

int addValues(int val1, int val2) {
    return val1 + val2;
}

int subValues(int val1, int val2) {
    return val1 - val2;
}

int mulValues(int val1, int val2) {
    return val1 * val2;
}

double divValues(int val1, int val2) {
    if (val2 == 0) {
        throw DivideByZeroException();
    }
    
    return static_cast<double>(val1) / val2;
}
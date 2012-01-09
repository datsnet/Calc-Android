#include <iostream>
#include <stdexcept>
using namespace std;

class DivideByZeroException : public runtime_error
{
public:
    DivideByZeroException() : runtime_error("Divide by Zero") {}
    DivideByZeroException(const DivideByZeroException & e) :
    runtime_error(e.what()) {}
};
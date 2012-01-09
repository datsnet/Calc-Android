#include <jni.h>
#include <Calculator.h>
#include <DivideByZeroException.h>

extern "C" {
	jint Java_com_datsumi_calc_Calc_addValues(JNIEnv* env, jobject thiz, jint val1, jint val2);
	jint Java_com_datsumi_calc_Calc_subValues(JNIEnv* env, jobject thiz, jint val1, jint val2);
	jint Java_com_datsumi_calc_Calc_mulValues(JNIEnv* env, jobject thiz, jint val1, jint val2);
	jdouble Java_com_datsumi_calc_Calc_divValues(JNIEnv* env, jobject thiz, jint val1, jint val2);
}

jint Java_com_datsumi_calc_Calc_addValues(JNIEnv* env, jobject thiz, jint val1, jint val2) {
	return addValues(val1, val2);
}

jint Java_com_datsumi_calc_Calc_subValues(JNIEnv* env, jobject thiz, jint val1, jint val2) {
	return subValues(val1, val2);
}

jint Java_com_datsumi_calc_Calc_mulValues(JNIEnv* env, jobject thiz, jint val1, jint val2) {
	return mulValues(val1, val2);
}

jdouble Java_com_datsumi_calc_Calc_divValues(JNIEnv* env, jobject thiz, jint val1, jint val2) {
	double answer = 0;

	try {
		answer = divValues(val1, val2);
	} catch (DivideByZeroException e) {
		jclass clazz = env->FindClass("com/datsumi/calc/DivideByZeroException");
		env->ThrowNew(clazz, "DivideByZero");
	}

	return answer;
}


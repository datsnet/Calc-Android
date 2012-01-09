LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := calculator
LOCAL_SRC_FILES := Calculator.cpp Calculator_wrapper.cpp
LOCAL_CPPFLAGS += -fexceptions

include $(BUILD_SHARED_LIBRARY)
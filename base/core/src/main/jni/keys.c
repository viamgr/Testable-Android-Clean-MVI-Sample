#include <jni.h>

JNIEXPORT jstring

JNICALL
Java_com_shishirstudio_ndktest_MainActivity_getFacebookApiKey(JNIEnv *env, jobject instance) {
    return (*env)->NewStringUTF(env, "TmF0aXZlNWVjcmV0UEBzc3cwcmQx");
}

JNIEXPORT jstring

JNICALL
Java_com_shishirstudio_ndktest_MainActivity_getBaseApi(JNIEnv *env, jobject instance) {
    return (*env)->NewStringUTF(env, "TmF0aXZlNWVjcmV0UEBzc3cwcmQy");
}
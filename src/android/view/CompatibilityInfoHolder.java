package android.view;

 import android.content.res.CompatibilityInfo;
 
 /** @hide */
 public class CompatibilityInfoHolder {
     private volatile CompatibilityInfo mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
 
     public void set(CompatibilityInfo compatInfo) {
         if (compatInfo != null && (compatInfo.isScalingRequired()
                 || !compatInfo.supportsScreen())) {
             mCompatInfo = compatInfo;
         } else {
             mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
         }
     }
 
     public CompatibilityInfo get() {
         return mCompatInfo;
     }
 
     public CompatibilityInfo getIfNeeded() {
         CompatibilityInfo ci = mCompatInfo;
         if (ci == null || ci  == CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO) {
             return null;
         }
         return ci;
     }
 }
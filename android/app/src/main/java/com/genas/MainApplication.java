package com.genas;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.genas.components.SystemManagerPackage;
import com.genas.components.list.Spot4BooksHorizontalListPackage;
import com.genas.components.map.Spot4BooksGoogleMapPackage;
import com.genas.components.simple.SimpleLabelViewPackage;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    protected boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
              new MainReactPackage(),
              new SimpleLabelViewPackage(),
              new Spot4BooksGoogleMapPackage(),
              new Spot4BooksHorizontalListPackage(),
              new SystemManagerPackage()
      );
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
      return mReactNativeHost;
  }
}

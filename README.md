


## **RxRetrofit-Android**

[![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=16)

**`RxRetrofit`** can be used to get make simple API calls. 


## **How to Use**

#### *STEP 1 - Declare dependencies in your project*

To add any `RxRetrofit` to your project, first make sure in root `build.gradle` you have specified the following repository:
```groovy
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

#### *STEP 2 - Initialize RxRetrofit with context, implement the interface `RxRetrofit.RxRetrofitCallBack` methods*

```groovy
  public class MainActivity extends AppCompatActivity implements RxRetrofit.RxRetrofitCallBack {//your class here}
```

```groovy
  RxRetrofit rxRetrofit = new RxRetrofit(this);
```

```groovy
    @Override
    public void getResult(Object result) {
        JsonElement jsonElement = gson.toJsonTree(result);
        YourPojo pojo = gson.fromJson(jsonElement, YourPojo.class);
    }
```

#### *STEP 3 - Get the data from the API call by using `getSimpleJsonQuery` method. Pass the base url, end point string, query parameters in form of map, scheduler for RxJava*

```groovy
    rxRetrofit.getSimpleJsonQuery(BASE_URL,END_POINT_STRING, data, null);
```

## ***Thats it !!***

## **License**

    MIT License

    Copyright (c) 2017 shashkiranr

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.

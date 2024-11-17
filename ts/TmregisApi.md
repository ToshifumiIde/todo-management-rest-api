# .TmregisApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createRegister**](TmregisApi.md#createRegister) | **POST** /register | ユーザー登録を実施する [機能ID] TMREGIS01
[**login**](TmregisApi.md#login) | **POST** /login | ログイン処理を実行する [機能ID] TMREGIS02


# **createRegister**
> void createRegister()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .TmregisApi(configuration);

let body:.TmregisApiCreateRegisterRequest = {
  // RegisterUserDto (optional)
  registerUserDto: {
    lastName: "田中",
    firstName: "太郎",
    email: "sample@gmail.com",
    password: "password",
    role: "ROLE_ADMIN",
  },
};

apiInstance.createRegister(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **registerUserDto** | **RegisterUserDto**|  |


### Return type

**void**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **login**
> JwtAuthResponse login()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .TmregisApi(configuration);

let body:.TmregisApiLoginRequest = {
  // LoginDto (optional)
  loginDto: {
    userNameOrEmail: "sample@gmail.com",
    password: "password",
  },
};

apiInstance.login(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **loginDto** | **LoginDto**|  |


### Return type

**JwtAuthResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**400** | Bad Request |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)



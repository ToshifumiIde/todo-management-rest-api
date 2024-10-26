# .TmtodoApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createTodo**](TmtodoApi.md#createTodo) | **POST** /todos | タスクを生成する [機能ID] TMTODO02
[**deleteTodoByUuid**](TmtodoApi.md#deleteTodoByUuid) | **DELETE** /todos/{uuid} | タスクを1件削除する
[**getTodoByUuid**](TmtodoApi.md#getTodoByUuid) | **GET** /todos/{uuid} | タスクを1件取得する [機能ID] TMTODO03
[**listTodos**](TmtodoApi.md#listTodos) | **GET** /todos | タスク一覧を取得する [機能ID] TMTODO01
[**putTodoByUuid**](TmtodoApi.md#putTodoByUuid) | **PUT** /todos/{uuid} | タスクを1件更新する [機能ID] TMTODO04


# **createTodo**
> void createTodo()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .TmtodoApi(configuration);

let body:.TmtodoApiCreateTodoRequest = {
  // TodoRegistrationDto (optional)
  todoRegistrationDto: {
    title: "タイトル",
    description: "説明",
    completed: true,
  },
};

apiInstance.createTodo(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **todoRegistrationDto** | **TodoRegistrationDto**|  |


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

# **deleteTodoByUuid**
> void deleteTodoByUuid()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .TmtodoApi(configuration);

let body:.TmtodoApiDeleteTodoByUuidRequest = {
  // string | TodoUUID
  uuid: "a123456789012345678901234567890z",
};

apiInstance.deleteTodoByUuid(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | [**string**] | TodoUUID | defaults to undefined


### Return type

**void**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**404** | Not Found |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **getTodoByUuid**
> TodoReadDto getTodoByUuid()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .TmtodoApi(configuration);

let body:.TmtodoApiGetTodoByUuidRequest = {
  // string | TodoUUID
  uuid: "a123456789012345678901234567890z",
};

apiInstance.getTodoByUuid(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | [**string**] | TodoUUID | defaults to undefined


### Return type

**TodoReadDto**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **listTodos**
> TodoReadDtoList listTodos()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .TmtodoApi(configuration);

let body:any = {};

apiInstance.listTodos(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters
This endpoint does not need any parameter.


### Return type

**TodoReadDtoList**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **putTodoByUuid**
> void putTodoByUuid()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .TmtodoApi(configuration);

let body:.TmtodoApiPutTodoByUuidRequest = {
  // string | TodoUUID
  uuid: "a123456789012345678901234567890z",
  // TodoUpdateDto (optional)
  todoUpdateDto: {
    title: "タイトル",
    description: "説明",
    completed: true,
  },
};

apiInstance.putTodoByUuid(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **todoUpdateDto** | **TodoUpdateDto**|  |
 **uuid** | [**string**] | TodoUUID | defaults to undefined


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



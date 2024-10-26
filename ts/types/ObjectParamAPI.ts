import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../http/http';
import { Configuration} from '../configuration'

import { TodoReadDto } from '../front.restapi.tmtodo.model/TodoReadDto';
import { TodoReadDtoList } from '../front.restapi.tmtodo.model/TodoReadDtoList';
import { TodoReadRow } from '../front.restapi.tmtodo.model/TodoReadRow';
import { TodoRegistrationDto } from '../front.restapi.tmtodo.model/TodoRegistrationDto';
import { TodoUpdateDto } from '../front.restapi.tmtodo.model/TodoUpdateDto';

import { ObservableTmtodoApi } from "./ObservableAPI";
import { TmtodoApiRequestFactory, TmtodoApiResponseProcessor} from "../apis/TmtodoApi";

export interface TmtodoApiCreateTodoRequest {
    /**
     * 
     * @type TodoRegistrationDto
     * @memberof TmtodoApicreateTodo
     */
    todoRegistrationDto?: TodoRegistrationDto
}

export interface TmtodoApiDeleteTodoByUuidRequest {
    /**
     * TodoUUID
     * @type string
     * @memberof TmtodoApideleteTodoByUuid
     */
    uuid: string
}

export interface TmtodoApiGetTodoByUuidRequest {
    /**
     * TodoUUID
     * @type string
     * @memberof TmtodoApigetTodoByUuid
     */
    uuid: string
}

export interface TmtodoApiListTodosRequest {
}

export interface TmtodoApiPutTodoByUuidRequest {
    /**
     * TodoUUID
     * @type string
     * @memberof TmtodoApiputTodoByUuid
     */
    uuid: string
    /**
     * 
     * @type TodoUpdateDto
     * @memberof TmtodoApiputTodoByUuid
     */
    todoUpdateDto?: TodoUpdateDto
}

export class ObjectTmtodoApi {
    private api: ObservableTmtodoApi

    public constructor(configuration: Configuration, requestFactory?: TmtodoApiRequestFactory, responseProcessor?: TmtodoApiResponseProcessor) {
        this.api = new ObservableTmtodoApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * タスクを生成する [機能ID] TMTODO02
     * @param param the request object
     */
    public createTodoWithHttpInfo(param: TmtodoApiCreateTodoRequest = {}, options?: Configuration): Promise<HttpInfo<void>> {
        return this.api.createTodoWithHttpInfo(param.todoRegistrationDto,  options).toPromise();
    }

    /**
     * タスクを生成する [機能ID] TMTODO02
     * @param param the request object
     */
    public createTodo(param: TmtodoApiCreateTodoRequest = {}, options?: Configuration): Promise<void> {
        return this.api.createTodo(param.todoRegistrationDto,  options).toPromise();
    }

    /**
     * タスクを1件削除する
     * @param param the request object
     */
    public deleteTodoByUuidWithHttpInfo(param: TmtodoApiDeleteTodoByUuidRequest, options?: Configuration): Promise<HttpInfo<void>> {
        return this.api.deleteTodoByUuidWithHttpInfo(param.uuid,  options).toPromise();
    }

    /**
     * タスクを1件削除する
     * @param param the request object
     */
    public deleteTodoByUuid(param: TmtodoApiDeleteTodoByUuidRequest, options?: Configuration): Promise<void> {
        return this.api.deleteTodoByUuid(param.uuid,  options).toPromise();
    }

    /**
     * タスクを1件取得する [機能ID] TMTODO03
     * @param param the request object
     */
    public getTodoByUuidWithHttpInfo(param: TmtodoApiGetTodoByUuidRequest, options?: Configuration): Promise<HttpInfo<TodoReadDto>> {
        return this.api.getTodoByUuidWithHttpInfo(param.uuid,  options).toPromise();
    }

    /**
     * タスクを1件取得する [機能ID] TMTODO03
     * @param param the request object
     */
    public getTodoByUuid(param: TmtodoApiGetTodoByUuidRequest, options?: Configuration): Promise<TodoReadDto> {
        return this.api.getTodoByUuid(param.uuid,  options).toPromise();
    }

    /**
     * タスク一覧を取得する [機能ID] TMTODO01
     * @param param the request object
     */
    public listTodosWithHttpInfo(param: TmtodoApiListTodosRequest = {}, options?: Configuration): Promise<HttpInfo<TodoReadDtoList>> {
        return this.api.listTodosWithHttpInfo( options).toPromise();
    }

    /**
     * タスク一覧を取得する [機能ID] TMTODO01
     * @param param the request object
     */
    public listTodos(param: TmtodoApiListTodosRequest = {}, options?: Configuration): Promise<TodoReadDtoList> {
        return this.api.listTodos( options).toPromise();
    }

    /**
     * タスクを1件更新する [機能ID] TMTODO04
     * @param param the request object
     */
    public putTodoByUuidWithHttpInfo(param: TmtodoApiPutTodoByUuidRequest, options?: Configuration): Promise<HttpInfo<void>> {
        return this.api.putTodoByUuidWithHttpInfo(param.uuid, param.todoUpdateDto,  options).toPromise();
    }

    /**
     * タスクを1件更新する [機能ID] TMTODO04
     * @param param the request object
     */
    public putTodoByUuid(param: TmtodoApiPutTodoByUuidRequest, options?: Configuration): Promise<void> {
        return this.api.putTodoByUuid(param.uuid, param.todoUpdateDto,  options).toPromise();
    }

}

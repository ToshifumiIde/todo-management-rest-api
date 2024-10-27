import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../http/http';
import { Configuration} from '../configuration'

import { TodoReadDto } from '../front.restapi.tmtodo.model/TodoReadDto';
import { TodoReadDtoList } from '../front.restapi.tmtodo.model/TodoReadDtoList';
import { TodoReadRow } from '../front.restapi.tmtodo.model/TodoReadRow';
import { TodoRegistrationDto } from '../front.restapi.tmtodo.model/TodoRegistrationDto';
import { TodoUpdateDto } from '../front.restapi.tmtodo.model/TodoUpdateDto';
import { ObservableTmtodoApi } from './ObservableAPI';

import { TmtodoApiRequestFactory, TmtodoApiResponseProcessor} from "../apis/TmtodoApi";
export class PromiseTmtodoApi {
    private api: ObservableTmtodoApi

    public constructor(
        configuration: Configuration,
        requestFactory?: TmtodoApiRequestFactory,
        responseProcessor?: TmtodoApiResponseProcessor
    ) {
        this.api = new ObservableTmtodoApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * タスクを1件完了する [機能ID] TMTODO06
     * @param uuid TodoUUID
     */
    public completeTodoByUuidWithHttpInfo(uuid: string, _options?: Configuration): Promise<HttpInfo<void>> {
        const result = this.api.completeTodoByUuidWithHttpInfo(uuid, _options);
        return result.toPromise();
    }

    /**
     * タスクを1件完了する [機能ID] TMTODO06
     * @param uuid TodoUUID
     */
    public completeTodoByUuid(uuid: string, _options?: Configuration): Promise<void> {
        const result = this.api.completeTodoByUuid(uuid, _options);
        return result.toPromise();
    }

    /**
     * タスクを生成する [機能ID] TMTODO02
     * @param todoRegistrationDto 
     */
    public createTodoWithHttpInfo(todoRegistrationDto?: TodoRegistrationDto, _options?: Configuration): Promise<HttpInfo<void>> {
        const result = this.api.createTodoWithHttpInfo(todoRegistrationDto, _options);
        return result.toPromise();
    }

    /**
     * タスクを生成する [機能ID] TMTODO02
     * @param todoRegistrationDto 
     */
    public createTodo(todoRegistrationDto?: TodoRegistrationDto, _options?: Configuration): Promise<void> {
        const result = this.api.createTodo(todoRegistrationDto, _options);
        return result.toPromise();
    }

    /**
     * タスクを1件削除する [機能ID] TMTODO05
     * @param uuid TodoUUID
     */
    public deleteTodoByUuidWithHttpInfo(uuid: string, _options?: Configuration): Promise<HttpInfo<void>> {
        const result = this.api.deleteTodoByUuidWithHttpInfo(uuid, _options);
        return result.toPromise();
    }

    /**
     * タスクを1件削除する [機能ID] TMTODO05
     * @param uuid TodoUUID
     */
    public deleteTodoByUuid(uuid: string, _options?: Configuration): Promise<void> {
        const result = this.api.deleteTodoByUuid(uuid, _options);
        return result.toPromise();
    }

    /**
     * タスクを1件取得する [機能ID] TMTODO03
     * @param uuid TodoUUID
     */
    public getTodoByUuidWithHttpInfo(uuid: string, _options?: Configuration): Promise<HttpInfo<TodoReadDto>> {
        const result = this.api.getTodoByUuidWithHttpInfo(uuid, _options);
        return result.toPromise();
    }

    /**
     * タスクを1件取得する [機能ID] TMTODO03
     * @param uuid TodoUUID
     */
    public getTodoByUuid(uuid: string, _options?: Configuration): Promise<TodoReadDto> {
        const result = this.api.getTodoByUuid(uuid, _options);
        return result.toPromise();
    }

    /**
     * タスクを1件未完了にする [機能ID] TMTODO07
     * @param uuid TodoUUID
     */
    public incompleteTodoByUuidWithHttpInfo(uuid: string, _options?: Configuration): Promise<HttpInfo<void>> {
        const result = this.api.incompleteTodoByUuidWithHttpInfo(uuid, _options);
        return result.toPromise();
    }

    /**
     * タスクを1件未完了にする [機能ID] TMTODO07
     * @param uuid TodoUUID
     */
    public incompleteTodoByUuid(uuid: string, _options?: Configuration): Promise<void> {
        const result = this.api.incompleteTodoByUuid(uuid, _options);
        return result.toPromise();
    }

    /**
     * タスク一覧を取得する [機能ID] TMTODO01
     */
    public listTodosWithHttpInfo(_options?: Configuration): Promise<HttpInfo<TodoReadDtoList>> {
        const result = this.api.listTodosWithHttpInfo(_options);
        return result.toPromise();
    }

    /**
     * タスク一覧を取得する [機能ID] TMTODO01
     */
    public listTodos(_options?: Configuration): Promise<TodoReadDtoList> {
        const result = this.api.listTodos(_options);
        return result.toPromise();
    }

    /**
     * タスクを1件更新する [機能ID] TMTODO04
     * @param uuid TodoUUID
     * @param todoUpdateDto 
     */
    public putTodoByUuidWithHttpInfo(uuid: string, todoUpdateDto?: TodoUpdateDto, _options?: Configuration): Promise<HttpInfo<void>> {
        const result = this.api.putTodoByUuidWithHttpInfo(uuid, todoUpdateDto, _options);
        return result.toPromise();
    }

    /**
     * タスクを1件更新する [機能ID] TMTODO04
     * @param uuid TodoUUID
     * @param todoUpdateDto 
     */
    public putTodoByUuid(uuid: string, todoUpdateDto?: TodoUpdateDto, _options?: Configuration): Promise<void> {
        const result = this.api.putTodoByUuid(uuid, todoUpdateDto, _options);
        return result.toPromise();
    }


}




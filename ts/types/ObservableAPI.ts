import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../http/http';
import { Configuration} from '../configuration'
import { Observable, of, from } from '../rxjsStub';
import {mergeMap, map} from  '../rxjsStub';
import { TodoReadDto } from '../front.restapi.tmtodo.model/TodoReadDto';
import { TodoReadDtoList } from '../front.restapi.tmtodo.model/TodoReadDtoList';
import { TodoReadRow } from '../front.restapi.tmtodo.model/TodoReadRow';
import { TodoRegistrationDto } from '../front.restapi.tmtodo.model/TodoRegistrationDto';
import { TodoUpdateDto } from '../front.restapi.tmtodo.model/TodoUpdateDto';

import { TmtodoApiRequestFactory, TmtodoApiResponseProcessor} from "../apis/TmtodoApi";
export class ObservableTmtodoApi {
    private requestFactory: TmtodoApiRequestFactory;
    private responseProcessor: TmtodoApiResponseProcessor;
    private configuration: Configuration;

    public constructor(
        configuration: Configuration,
        requestFactory?: TmtodoApiRequestFactory,
        responseProcessor?: TmtodoApiResponseProcessor
    ) {
        this.configuration = configuration;
        this.requestFactory = requestFactory || new TmtodoApiRequestFactory(configuration);
        this.responseProcessor = responseProcessor || new TmtodoApiResponseProcessor();
    }

    /**
     * タスクを1件完了する [機能ID] TMTODO06
     * @param uuid TodoUUID
     */
    public completeTodoByUuidWithHttpInfo(uuid: string, _options?: Configuration): Observable<HttpInfo<void>> {
        const requestContextPromise = this.requestFactory.completeTodoByUuid(uuid, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.completeTodoByUuidWithHttpInfo(rsp)));
            }));
    }

    /**
     * タスクを1件完了する [機能ID] TMTODO06
     * @param uuid TodoUUID
     */
    public completeTodoByUuid(uuid: string, _options?: Configuration): Observable<void> {
        return this.completeTodoByUuidWithHttpInfo(uuid, _options).pipe(map((apiResponse: HttpInfo<void>) => apiResponse.data));
    }

    /**
     * タスクを生成する [機能ID] TMTODO02
     * @param todoRegistrationDto 
     */
    public createTodoWithHttpInfo(todoRegistrationDto?: TodoRegistrationDto, _options?: Configuration): Observable<HttpInfo<void>> {
        const requestContextPromise = this.requestFactory.createTodo(todoRegistrationDto, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.createTodoWithHttpInfo(rsp)));
            }));
    }

    /**
     * タスクを生成する [機能ID] TMTODO02
     * @param todoRegistrationDto 
     */
    public createTodo(todoRegistrationDto?: TodoRegistrationDto, _options?: Configuration): Observable<void> {
        return this.createTodoWithHttpInfo(todoRegistrationDto, _options).pipe(map((apiResponse: HttpInfo<void>) => apiResponse.data));
    }

    /**
     * タスクを1件削除する [機能ID] TMTODO05
     * @param uuid TodoUUID
     */
    public deleteTodoByUuidWithHttpInfo(uuid: string, _options?: Configuration): Observable<HttpInfo<void>> {
        const requestContextPromise = this.requestFactory.deleteTodoByUuid(uuid, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.deleteTodoByUuidWithHttpInfo(rsp)));
            }));
    }

    /**
     * タスクを1件削除する [機能ID] TMTODO05
     * @param uuid TodoUUID
     */
    public deleteTodoByUuid(uuid: string, _options?: Configuration): Observable<void> {
        return this.deleteTodoByUuidWithHttpInfo(uuid, _options).pipe(map((apiResponse: HttpInfo<void>) => apiResponse.data));
    }

    /**
     * タスクを1件取得する [機能ID] TMTODO03
     * @param uuid TodoUUID
     */
    public getTodoByUuidWithHttpInfo(uuid: string, _options?: Configuration): Observable<HttpInfo<TodoReadDto>> {
        const requestContextPromise = this.requestFactory.getTodoByUuid(uuid, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getTodoByUuidWithHttpInfo(rsp)));
            }));
    }

    /**
     * タスクを1件取得する [機能ID] TMTODO03
     * @param uuid TodoUUID
     */
    public getTodoByUuid(uuid: string, _options?: Configuration): Observable<TodoReadDto> {
        return this.getTodoByUuidWithHttpInfo(uuid, _options).pipe(map((apiResponse: HttpInfo<TodoReadDto>) => apiResponse.data));
    }

    /**
     * タスクを1件未完了にする [機能ID] TMTODO07
     * @param uuid TodoUUID
     */
    public incompleteTodoByUuidWithHttpInfo(uuid: string, _options?: Configuration): Observable<HttpInfo<void>> {
        const requestContextPromise = this.requestFactory.incompleteTodoByUuid(uuid, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.incompleteTodoByUuidWithHttpInfo(rsp)));
            }));
    }

    /**
     * タスクを1件未完了にする [機能ID] TMTODO07
     * @param uuid TodoUUID
     */
    public incompleteTodoByUuid(uuid: string, _options?: Configuration): Observable<void> {
        return this.incompleteTodoByUuidWithHttpInfo(uuid, _options).pipe(map((apiResponse: HttpInfo<void>) => apiResponse.data));
    }

    /**
     * タスク一覧を取得する [機能ID] TMTODO01
     */
    public listTodosWithHttpInfo(_options?: Configuration): Observable<HttpInfo<TodoReadDtoList>> {
        const requestContextPromise = this.requestFactory.listTodos(_options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.listTodosWithHttpInfo(rsp)));
            }));
    }

    /**
     * タスク一覧を取得する [機能ID] TMTODO01
     */
    public listTodos(_options?: Configuration): Observable<TodoReadDtoList> {
        return this.listTodosWithHttpInfo(_options).pipe(map((apiResponse: HttpInfo<TodoReadDtoList>) => apiResponse.data));
    }

    /**
     * タスクを1件更新する [機能ID] TMTODO04
     * @param uuid TodoUUID
     * @param todoUpdateDto 
     */
    public putTodoByUuidWithHttpInfo(uuid: string, todoUpdateDto?: TodoUpdateDto, _options?: Configuration): Observable<HttpInfo<void>> {
        const requestContextPromise = this.requestFactory.putTodoByUuid(uuid, todoUpdateDto, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.putTodoByUuidWithHttpInfo(rsp)));
            }));
    }

    /**
     * タスクを1件更新する [機能ID] TMTODO04
     * @param uuid TodoUUID
     * @param todoUpdateDto 
     */
    public putTodoByUuid(uuid: string, todoUpdateDto?: TodoUpdateDto, _options?: Configuration): Observable<void> {
        return this.putTodoByUuidWithHttpInfo(uuid, todoUpdateDto, _options).pipe(map((apiResponse: HttpInfo<void>) => apiResponse.data));
    }

}

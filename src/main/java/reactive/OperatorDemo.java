package reactive;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sumit.jha on 19/09/18.
 */
public class OperatorDemo {

    public static void main(String[] args) {
        Observable<Object> integerObservable = Observable.fromArray(1, 2, new RuntimeException("failed"));
        Observable<String> stringObservable = Observable.fromArray("first", "second", "third");

//        Observable.zip(integerObservable, stringObservable, (num, str) -> String.valueOf(num) + str)
//                .doOnError(err -> {
//                    System.out.println("Inside error handler");
//                    err.printStackTrace();
//                })
//                .blockingForEach(System.out::println);


        //integerObservable.subscribe(obj -> System.out.println(obj.toString()));
        integerObservable.doOnComplete(() -> System.out.println("Completed."))
                .doOnNext(val -> {
                    System.out.println("on next: thread = " + Thread.currentThread().getName());
                })
                .doOnError(throwable -> {
                    System.out.println("on error: thread = " + Thread.currentThread().getName());
                })
                .doOnSubscribe(disposable -> {
                    System.out.println("subscribed: thread = " + Thread.currentThread().getName());
                })
                .subscribeOn(Schedulers.io())
                .subscribe();
    }
}

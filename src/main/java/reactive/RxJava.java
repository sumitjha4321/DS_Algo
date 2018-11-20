package reactive;

import io.reactivex.*;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class RxJava {
    public static void main(String[] args) {



        Observable
                .range(0, 10)
                .subscribe((i) -> {
                    //System.out.println(i);
                });


        Observable<Integer> integerObservable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(5);
                emitter.onNext(6);
                emitter.onNext(7);
                emitter.onComplete();
            }
        });

        Observable<Object> stringObservable = Observable.create(emitter -> {
            System.out.println("Inside emitter");
            System.out.println(emitter.getClass());
            emitter.onNext("First");
            emitter.onNext("Second");
            emitter.onNext("Third");
            emitter.onComplete();

        }).cache();

        stringObservable.subscribe(str -> System.out.println(str));
        stringObservable.subscribe(str -> System.out.println(str));


    }
}

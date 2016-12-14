package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import timber.log.Timber;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        // Plant logger cf. Android Timber
        Timber.plant(new Timber.DebugTree());

        // TODO build Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // TODO create a service
        BookService service = retrofit.create(BookService.class);

        // TODO listBooks()
        Call<List<Book>> call = service.listBooks();

        // TODO enqueue call and display book title
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Response<List<Book>> response, Retrofit retrofit) {
                // TODO success
                // TODO log books
                // TODO display book as a list
                for (Book book : response.body()) {
                    Timber.i(book.getTitle());
                }
            }
            @Override
            public void onFailure(Throwable t) {
                // TODO error occurred
                Timber.i("Error ! Explosion of the phone in 3 ... 2 ... 1 ...");
            }
        });
    }

}

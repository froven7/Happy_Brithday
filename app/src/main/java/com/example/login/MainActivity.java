package com.example.login;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.graphics.EmbossMaskFilter;
import android.os.Bundle;
import android.widget.Button;

import com.example.login.R;

import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.Party;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.core.models.Size;
import nl.dionsegijn.konfetti.xml.KonfettiView;

public class MainActivity extends AppCompatActivity {
KonfettiView konfettiView;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        konfettiView=findViewById(R.id.konfettiview);

Shape.DrawableShape drawableShape=new Shape.DrawableShape(AppCompatResources.getDrawable(this,R.drawable.ic_android),true);
        button.setOnClickListener(view -> {
            EmitterConfig emitterConfig=new Emitter(300, TimeUnit.MILLISECONDS).max(300);


            konfettiView.start(
                    new PartyFactory(emitterConfig)
                            .shapes(Shape.Circle.INSTANCE,Shape.Square.INSTANCE,drawableShape)
                            .spread(360)
                            .position(0.5,0.5,1,1)
                            .sizes(new Size(8,50,10))
                            .timeToLive(10000)
                            .fadeOutEnabled(true)
                            .build()
                );
        });
    }
}
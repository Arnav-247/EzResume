package com.codechef.ezresume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.pdf.PdfDocument;
import android.graphics.pdf.PdfRenderer;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

//import com.tom_roush.pdfbox.pdmodel.PDDocument;
//import com.tom_roush.pdfbox.pdmodel.PDPage;
//import com.tom_roush.pdfbox.pdmodel.PDPageContentStream;
//import com.tom_roush.pdfbox.pdmodel.font.PDFont;
//import com.tom_roush.pdfbox.pdmodel.font.PDType1Font;
//import com.tom_roush.pdfbox.pdmodel.graphics.image.JPEGFactory;
//import com.tom_roush.pdfbox.pdmodel.graphics.image.LosslessFactory;
//import com.tom_roush.pdfbox.pdmodel.graphics.image.PDImageXObject;
//import com.tom_roush.pdfbox.rendering.PDFRenderer;
//import com.tom_roush.pdfbox.util.PDFBoxResourceLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity
{
    ImageView img;
    Button btn;
    File root;
    Bitmap pageImage;
    String fileName = "mypdf.pdf";
    LinearLayout linearLayout;
    JSONHandler dataHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String state = Environment.getExternalStorageState();
        requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,READ_EXTERNAL_STORAGE}, 1);
        dataHandler = new JSONHandler(this);
        //external storage availability check
//        if (!Environment.MEDIA_MOUNTED.equals(state)) {
//            Log.d("MainActivity", "Can't Locate External Storage");
//            return;
//        }
//        root = new File(Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_DOCUMENTS), fileName);

        root = new File(getFilesDir(),fileName);


        linearLayout = findViewById(R.id.container);
        img = findViewById(R.id.imageView);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.d("TIMELOG::", "Started");
                createPDF();
                //renderFileToJpg();
                renderPDF();
                Log.d("TIMELOG::", "Ended");
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();
       // setup();
    }



    void createPDF()
    {
        PdfDocument document = new PdfDocument();
        Log.d("WIDTH", String.valueOf(linearLayout.getWidth()));
        Log.d("Height", String.valueOf(linearLayout.getHeight()));
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(linearLayout.getWidth(), linearLayout.getHeight(), 1).create();
        PdfDocument.Page page = document.startPage(pageInfo);
        linearLayout.draw(page.getCanvas());
        document.finishPage(page);

        try
        {
            FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);
            document.writeTo(fos);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        document.close();
    }

    public void renderPDF() {
        // Render the page and save it to an image file
        try {
            // Load in an already created PDF
            ParcelFileDescriptor pfd = ParcelFileDescriptor.open(root,ParcelFileDescriptor.MODE_READ_ONLY);
            PdfRenderer renderer = new PdfRenderer(pfd);
            PdfRenderer.Page page = renderer.openPage(0);
            pageImage = Bitmap.createBitmap(page.getWidth(),page.getHeight(),Bitmap.Config.ARGB_8888);

            page.render(pageImage,null,null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
            page.close();
            renderer.close();
            //PDDocument document = PDDocument.load(new FileInputStream(root));
            // Create a renderer for the document
           // PDFRenderer renderer = new PDFRenderer(document);
            // Render the image to an RGB Bitmap
            //pageImage = renderer.renderImage(0, 1, Bitmap.Config.ARGB_8888);
            img.setImageBitmap(pageImage);
            Log.d("MainActivity", "PDF Displayed");
            // Save the render result to an image
//            String path = root.getAbsolutePath() + "/render.jpg";
//            File renderFile = new File(path);
//            FileOutputStream fileOut = new FileOutputStream(renderFile);
//            pageImage.compress(Bitmap.CompressFormat.JPEG, 100, fileOut);
//            fileOut.close();
//            Toast.makeText(getApplicationContext(),"Successfully rendered image to " + path, Toast.LENGTH_LONG).show();
            // Optional: display the render result on screen
            // displayRenderedImage(path);
        }
        catch (IOException e)
        {
            Log.e("PdfBox-Android-Sample", "Exception thrown while rendering file", e);
        }
    }
}























//    private void setup()
//    {
//        PDFBoxResourceLoader.init(getApplicationContext());
//        root = new File(getFilesDir(),"EZResume.pdf");
//        //newFile = new File(root, fileName);
////        if(!root.exists())
////        {
////            root.mkdir();
////        }
//        //root = getApplicationContext().getCacheDir();
//        assetManager = getAssets();
//        img = findViewById(R.id.imageView);
//        btn = findViewById(R.id.button);
//        btn.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                createPdf(txt.getText().toString());
//                renderFileToJpg();
//            }
//        });
//
//    }
//
//    public void createPdf(String text) {
//        PDDocument document = new PDDocument();
//        PDPage page = new PDPage();
//        document.addPage(page);
//
//        // Create a new font object selecting one of the PDF base fonts
//        PDFont font = PDType1Font.HELVETICA;
//        // Or a custom font
////        try
////        {
////            // Replace MyFontFile with the path to the asset font you'd like to use.
////            // Or use LiberationSans "com/tom_roush/pdfbox/resources/ttf/LiberationSans-Regular.ttf"
////            font = PDType0Font.load(document, assetManager.open("MyFontFile.TTF"));
////        }
////        catch (IOException e)
////        {
////            Log.e("PdfBox-Android-Sample", "Could not load font", e);
////        }
//        PDPageContentStream contentStream;
//
//        try {
//            // Define a content stream for adding to the PDF
//            contentStream = new PDPageContentStream(document, page);
//
//            // Write Hello World in blue text
//            contentStream.beginText();
//            contentStream.setNonStrokingColor(15, 38, 192);
//            contentStream.setFont(font, 30);
//            contentStream.newLineAtOffset(100, 700);
//            contentStream.showText(text);
//            contentStream.endText();
//
//            // Load in the images
//            InputStream in = assetManager.open("falcon.jpg");
//            InputStream alpha = assetManager.open("trans.png");
//
//            // Draw a green rectangle
//            contentStream.addRect(5, 500, 100, 100);
//            contentStream.setNonStrokingColor(0, 255, 125);
//            contentStream.fill();
//
//            // Draw the falcon base image
//            PDImageXObject ximage = JPEGFactory.createFromStream(document, in);
//            contentStream.drawImage(ximage, 20, 20);
//
//            // Draw the red overlay image
//            Bitmap alphaImage = BitmapFactory.decodeStream(alpha);
//            PDImageXObject alphaXimage = LosslessFactory.createFromImage(document, alphaImage);
//            contentStream.drawImage(alphaXimage, 20, 20 );
//
//            // Make sure that the content stream is closed:
//            contentStream.close();
//
//            // Save the final pdf document to a file
//
//
//            String path = root.getAbsolutePath();//root.getAbsolutePath() + "/Created.pdf";
//            Log.d("MainActivity", "PATH: " + path);
//            document.save(path);
//            document.close();
//            Toast.makeText(getApplicationContext(), "Successfully wrote PDF to " + path, Toast.LENGTH_LONG).show();
//            Log.d("MainActivity", "PDF Created");
//
//        } catch (IOException e) {
//            Log.e("PdfBox-Android-Sample", "Exception thrown while creating PDF", e);
//        }
//    }

//    public void renderFileToJpg() {
//        // Render the page and save it to an image file
//        try {
//            // Load in an already created PDF
//            PDDocument document = PDDocument.load(new FileInputStream(root));
//            // Create a renderer for the document
//            PDFRenderer renderer = new PDFRenderer(document);
//            // Render the image to an RGB Bitmap
//            pageImage = renderer.renderImage(0, 1, Bitmap.Config.ARGB_8888);
//            img.setImageBitmap(pageImage);
//            Log.d("MainActivity", "PDF Displayed");
//            // Save the render result to an image
////            String path = root.getAbsolutePath() + "/render.jpg";
////            File renderFile = new File(path);
////            FileOutputStream fileOut = new FileOutputStream(renderFile);
////            pageImage.compress(Bitmap.CompressFormat.JPEG, 100, fileOut);
////            fileOut.close();
////            Toast.makeText(getApplicationContext(),"Successfully rendered image to " + path, Toast.LENGTH_LONG).show();
//            // Optional: display the render result on screen
//           // displayRenderedImage(path);
//        }
//        catch (IOException e)
//        {
//            Log.e("PdfBox-Android-Sample", "Exception thrown while rendering file", e);
//        }
//    }
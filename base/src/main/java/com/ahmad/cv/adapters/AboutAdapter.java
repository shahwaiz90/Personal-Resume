package com.ahmad.cv.adapters;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmad.cv.model.DemoItem;
import com.ahmad.cv.base.R;
import com.squareup.picasso.Picasso;
import java.util.List;
import static android.content.Context.CLIPBOARD_SERVICE;

public class AboutAdapter extends RecyclerView.Adapter {

    private List<DemoItem> demoItems;
    private Context         context;

    public AboutAdapter(List<DemoItem> demoItems, Context context) {
        this.demoItems = demoItems;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.about, parent, false);
        return new DemoItemHolder1(row);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AboutAdapter.DemoItemHolder1 demoItemHolder = (AboutAdapter.DemoItemHolder1) holder;
        Picasso.get().load(R.drawable.envelope).into(demoItemHolder.emailIcon);
        Picasso.get().load(R.drawable.placeholder).into(demoItemHolder.addressIcon);
        Picasso.get().load(R.drawable.smartphone).into(demoItemHolder.phoneIcon);
        Picasso.get().load(R.drawable.linkedin).into(demoItemHolder.linkedinIcon);
        Picasso.get().load(R.drawable.github).into(demoItemHolder.githubIcon);
        Picasso.get().load(R.drawable.stackoverflow).into(demoItemHolder.stackOverFlowIcon);



        Picasso.get().load(R.drawable.copy).into(demoItemHolder.emailLinkCopy);
        Picasso.get().load(R.drawable.copy).into(demoItemHolder.addressLinkCopy);
        Picasso.get().load(R.drawable.copy).into(demoItemHolder.phoneLinkCopy);
        Picasso.get().load(R.drawable.copy).into(demoItemHolder.linkedinLinkCopy);

        Picasso.get().load(R.drawable.copy).into(demoItemHolder.githubLinkCopy);
        Picasso.get().load(R.drawable.copy).into(demoItemHolder.stackoverflowLinkCopy);



        Picasso.get().load(R.drawable.openlink).into(demoItemHolder.email);

        Picasso.get().load(R.drawable.phone).into(demoItemHolder.phone);
        Picasso.get().load(R.drawable.openlink).into(demoItemHolder.linkedin);
        Picasso.get().load(R.drawable.openlink).into(demoItemHolder.github);
        Picasso.get().load(R.drawable.openlink).into(demoItemHolder.stackOverFlow);


        demoItemHolder.email.setOnClickListener(view -> {
           Intent intent=new Intent(Intent.ACTION_SEND);
           String[] recipients={context.getString(R.string.email)};
           intent.putExtra(Intent.EXTRA_EMAIL, recipients);
           intent.setType("text/html");
           intent.setPackage("com.google.android.gm");
           context.startActivity(Intent.createChooser(intent, "Send mail"));
       });


        demoItemHolder.phone.setOnClickListener(view -> {
            Uri u = Uri.parse("tel:" +context.getString(R.string.phoneNumber));
            Intent i = new Intent(Intent.ACTION_DIAL, u);
            try
            {
                // Launch the Phone app's dialer with a phone
                // number to dial a call.
                context.startActivity(i);
            }
            catch (SecurityException s)
            {
                // show() method display the toast with
                // exception message.
                Toast.makeText(context ,"issue check the code", Toast.LENGTH_LONG)
                        .show();
            }
        });
        demoItemHolder.linkedin.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://add/%@" + context.getString(R.string.Linkedin_IdLink)));
            final PackageManager packageManager = context.getPackageManager();
            final List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
            if (list.isEmpty()) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.linkedin.com/profile/view?id=" + (R.string.Linkedin_IdLink)));
            }
            context.startActivity(intent);
        });

        demoItemHolder.github.setOnClickListener(view -> {
            Intent  intent = new Intent(Intent.ACTION_VIEW, Uri.parse(context.getString(R.string.Github_IdLink)));
            context.startActivity(intent);
        });
        demoItemHolder.stackOverFlow.setOnClickListener(view -> {
           Intent  intent = new Intent(Intent.ACTION_VIEW, Uri.parse(context.getString(R.string.stackOverFlow_IdLink)));
            context.startActivity(intent);
        });
       
        demoItemHolder.emailLinkCopy.setOnClickListener(view -> {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("Text Label", context.getString(R.string.email));
            assert clipboard != null;
            clipboard.setPrimaryClip(clip);
            Toast.makeText(context, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
        });
       
        demoItemHolder.addressLinkCopy.setOnClickListener(view -> {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("Text Label", context.getString(R.string.Address));
            assert clipboard != null;
            clipboard.setPrimaryClip(clip);
            Toast.makeText(context, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
        });
       
        demoItemHolder.phoneLinkCopy.setOnClickListener(view -> {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("Text Label", context.getString(R.string.phoneNumber));
            assert clipboard != null;
            clipboard.setPrimaryClip(clip);
            Toast.makeText(context, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
        });
       
        demoItemHolder.phoneLinkCopy.setOnClickListener(view -> {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("Text Label", context.getString(R.string.phoneNumber));
            assert clipboard != null;
            clipboard.setPrimaryClip(clip);
            Toast.makeText(context, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
        });

        demoItemHolder.linkedinLinkCopy.setOnClickListener(view -> {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("Text Label", context.getString(R.string.Linkedin_UserName));
            assert clipboard != null;
            clipboard.setPrimaryClip(clip);
            Toast.makeText(context, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
        });

        demoItemHolder.githubLinkCopy.setOnClickListener(view -> {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("Text Label", context.getString(R.string.Github_UserName));
            assert clipboard != null;
            clipboard.setPrimaryClip(clip);
            Toast.makeText(context, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
        });
        demoItemHolder.stackoverflowLinkCopy.setOnClickListener(view -> {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("Text Label", context.getString(R.string.StackOverFlow_UserName));
            assert clipboard != null;
            clipboard.setPrimaryClip(clip);
            Toast.makeText(context, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
        });

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    }
    @Override
    public int getItemCount() {
        return demoItems.size();
    }
    public class DemoItemHolder1 extends RecyclerView.ViewHolder {
        ImageView email,phone,linkedin,github,stackOverFlow;
        ImageView emailIcon,addressIcon,phoneIcon,linkedinIcon,githubIcon,stackOverFlowIcon;
        ImageView emailLinkCopy,addressLinkCopy,phoneLinkCopy,linkedinLinkCopy,githubLinkCopy,stackoverflowLinkCopy;
        DemoItemHolder1(View itemView) {
            super(itemView);
            /*--------------------TextView------------------*/
            email                =itemView.findViewById(R.id.emailIntentLink);
            phone                =itemView.findViewById(R.id.phoneCallLink);
            linkedin             =itemView.findViewById(R.id.linkedinIntentLink);
            github               =itemView.findViewById(R.id.githubIntentLink);
            stackOverFlow        =itemView.findViewById(R.id.stackOverFlowIntentLink);
            /*--------------------Icons------------------*/
            emailIcon            =itemView.findViewById(R.id.emailIcon);
            addressIcon          =itemView.findViewById(R.id.addressIcon);
            phoneIcon            =itemView.findViewById(R.id.phoneIcon);
            linkedinIcon         =itemView.findViewById(R.id.linkedinIcon);
            githubIcon           =itemView.findViewById(R.id.githubIcon);
            stackOverFlowIcon    =itemView.findViewById(R.id.stackOverFlowIcon);
            /*--------------------Links------------------*/
            emailLinkCopy        =itemView.findViewById(R.id.emaailCopyLink);
            addressLinkCopy      =itemView.findViewById(R.id.addressCopyLink);
            phoneLinkCopy        =itemView.findViewById(R.id.phoneCopyLink);
            linkedinLinkCopy     =itemView.findViewById(R.id.linkedinCopyLink);
            githubLinkCopy       =itemView.findViewById(R.id.githubCopyLink);
            stackoverflowLinkCopy=itemView.findViewById(R.id.stackOverFlowCopyLink);

        }
    }

}

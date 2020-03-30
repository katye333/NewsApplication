package com.example.android.newsapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ArticleAdapter extends ArrayAdapter<Article> {

    /**
     * Constructs a new {@link ArticleAdapter}.
     *
     * @param context of the app
     * @param articles is the list of articles, ie., the data source of the adapter
     */
    public ArticleAdapter(Context context, List<Article> articles) {
        super(context, 0, articles);
    }

    /**
     * Returns a list item view that shows info about the article at the given
     * position in the list of articles
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Article currentArticle = getItem(position);

        TextView pillarTextView = listItemView.findViewById(R.id.pillar_name_text_view);
        pillarTextView.setText(currentArticle.getPilllarName());

        TextView titleTextView = listItemView.findViewById(R.id.title_text_view);
        titleTextView.setText(currentArticle.getTitle());

        TextView authorTextView = listItemView.findViewById(R.id.author_text_view);
        authorTextView.setText(currentArticle.getAuthor());

        // Get publication date and format it appropiately
        Date dateObject = currentArticle.getDate();

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date_text_view);
        dateView.setText(formatDate(dateObject).toString());

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time_text_view);
        timeView.setText(formatTime(dateObject).toString());

        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
//        Date date = new Date(dateObject);
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}

package app.game.swapd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

// Adapter class for managing a RecyclerView. This adapter allows for deletion of an item
// when the user swipes left.
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    // List of items (in this case, strings) displayed by the RecyclerView.
    private final List<String> itemList;

    // Constructor for the adapter that accepts a list of items.
    public MyAdapter(List<String> itemList) {
        this.itemList = itemList;
    }

    // Called when RecyclerView needs a new ViewHolder to represent an item.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout (item_layout.xml) and create a ViewHolder for it.
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    // Called to display data at the specified position in the RecyclerView.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Set the text of the TextView in the ViewHolder to the corresponding item from itemList.
        holder.itemText.setText(itemList.get(position));
    }

    // Returns the total number of items in the itemList.
    @Override
    public int getItemCount() {
        return itemList.size();
    }

    // Deletes an item at a specific position and notifies the RecyclerView about the removal.
    // This method is called when the user swipes left on an item.
    public void deleteItem(int position) {
        // Remove the item from the list.
        itemList.remove(position);
        // Notify the adapter about the removal of the item at the specific position.
        notifyItemRemoved(position);
    }

    // ViewHolder class that holds the references to the views (in this case, the TextView)
    // for each item in the RecyclerView.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // TextView that displays the item text.
        TextView itemText;

        // ViewHolder constructor that initializes the TextView reference.
        public ViewHolder(View view) {
            super(view);
            // Find the TextView within the item layout.
            itemText = view.findViewById(R.id.itemText);
        }
    }
}
